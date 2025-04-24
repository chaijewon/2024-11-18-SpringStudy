<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.page-link{
  cursor: pointer;
}
</style>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>영화</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i></a></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80" id="listApp">
        <div class="container">
               <div class="text-center" style="display: block">
                  <input type="button" class="btn-lg btn-danger"
                    value="인기영화" @click="view('https://api.themoviedb.org/3/movie/popular')"
                  >
                  <input type="button" class="btn-lg btn-info"
                    value="현재 상영작" @click="view('https://api.themoviedb.org/3/movie/now_playing')"
                  >
                  <input type="button" class="btn-lg btn-success"
                    value="인기 TV쇼" @click="view('https://api.themoviedb.org/3/tv/popular')"
                  >
                  <input type="button" class="btn-lg btn-warning"
                    value="TV 쇼 순위" @click="view('https://api.themoviedb.org/3/tv/top_rated')"
                  >
                </div>
                <div style="height: 20px"></div>
            <div class="row">
                
                <!-- Single Post -->
                <div class="col-12 col-md-6 col-lg-4" v-for="vo in movies">
                    <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                         <a :href="'https://www.themoviedb.org/movie/'+vo.id">
                          <img :src="'https://image.tmdb.org/t/p/w500'+vo.poster_path">
                         </a>
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="#">{{vo.vote_average}}</a>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            <a href="#">
                                <h4 class="post-headline">{{vo.title}}</h4>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <script>
    let listApp=Vue.createApp({
    	// 멤버변수 => Model => 변경시에는 바로 View(JSP)에 적용
    	data(){
    		return {
    		  movies:[]
    		}
    	},
    	// VM => ViewModel => 변수를 변경하는 역할 
    	// MVVM : 필수로 면접 
    	mounted(){
    	   
    	},
    	// 사용자 정의 함수 정의 => 이벤트 
    	methods:{
    		view(url){
    		   axios.get(url+"?api_key=697729d3f274ce88cf5729d38280fd33")
    		   .then(res=>{
    			   this.movies=res.data.results
    		   })
    		   .catch(error=>{
    			   console.log(error.response)
    		   })
    		}
    	}
    }).mount("#listApp")
    </script>
</body>
</html>
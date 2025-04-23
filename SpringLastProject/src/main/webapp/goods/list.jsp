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
                        <h2>부산 맛집 목록</h2>
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
            <div class="row">

                <!-- Single Post -->
                <div class="col-12 col-md-6 col-lg-4" v-for="vo in list">
                    <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                            <img :src="'https://www.menupan.com'+vo.poster" alt="">
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="#">{{vo.address}}</a>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            <a :href="'../food/detail.do?fno='+vo.fno">
                                <h4 class="post-headline">{{vo.name}}</h4>
                            </a>
                        </div>
                    </div>
                </div>

                

                <div class="col-12">
                    <div class="pagination-area d-sm-flex mt-15">
                        <nav aria-label="#">
                            <ul class="pagination">
                                <li class="page-item" v-if="startPage>1">
                                    <a class="page-link" @click="prev()">이전 <i class="fa fa-angle-double-left" aria-hidden="true"></i></a>
                                </li>
                                <li :class="i==curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)"><a class="page-link" @click="pageChange(i)">{{i}}</a></li>
                                
                                <li class="page-item" v-if="endPage<totalpage">
                                    <a class="page-link" @click="next()">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                                </li>
                            </ul>
                        </nav>
                        <div class="page-status">
                            <p>Page {{curpage}} of {{totalpage}} results</p>
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
    			list:[],
    			curpage:1,
    			totalpage:0,
    			startPage:0,
    			endPage:0
    			
    		}
    	},
    	// VM => ViewModel => 변수를 변경하는 역할 
    	// MVVM : 필수로 면접 
    	mounted(){
    		// 시작과 동시에 데이터 읽기 => window.onload 
    		// jquery/angularjs => 연동시에 주로 사용 
    		// $(function(){})
    		// useEffect()
    		this.dataRecv()
    	},
    	// 사용자 정의 함수 정의 => 이벤트 
    	methods:{
    		prev(){
    			this.curpage=this.startPage-1
    			this.dataRecv()
    		},
    		next(){
    			this.curpage=this.endPage+1
    			this.dataRecv()
    		},
    		pageChange(page){
    			this.curpage=page
    			this.dataRecv()
    		},
    		range(start,end){
    			let arr=[]
    			let len=end-start
    			for(let i=0;i<=len;i++)
    			{
    				arr[i]=start
    				start++
    			}
    			return arr
    		},
    		dataRecv(){
    			axios.get('http://localhost:8080/web/food/list_vue.do',{
        			params:{
        				page:this.curpage,
        				cno:this.cno
        			}
        		}).then(res=>{
        			console.log(res.date)
        			this.list=res.data.list
        			this.curpage=res.data.curpage
        			this.totalpage=res.data.totalpage
        			this.startPage=res.data.startPage
        			this.endPage=res.data.endPage
        		}).catch(error=>{
        			console.log(error.response)
        		})
    		}
    	}
    	/*,
    	components:{
    		
    	},
    	computed:{
    		
    	}*/
    }).mount("#listApp")
    </script>
</body>
</html>
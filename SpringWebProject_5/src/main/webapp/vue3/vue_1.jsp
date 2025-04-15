<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="
https://cdn.jsdelivr.net/npm/vue3-bootstrap-paginate@1.0.0/dist/vue3-bootstrap-paginate.umd.min.js
"></script>
</head>
<body>
<div id="app">
    <button type="button" class="btn btn-success btn-sm" @click="hello">click me</button>
    <br>
    
</div>

<script>
    var app = Vue.createApp({
        methods: {
            hello(){
                alert('hello~');
            }
        },
    }).mount('#app')
</script>
</body>
</html>
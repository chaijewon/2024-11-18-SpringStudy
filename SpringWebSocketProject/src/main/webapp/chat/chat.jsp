<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
h3{
  text-align: center;
}
#chatArea{
  width: 400px;
  height: 280px;
  overflow-y:auto;
  border:1px solid black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
// 서버 연결 
function connection()
{
	  websocket=new WebSocket("ws://localhost:8080/web/chat-ws.do")
	  websocket.onopen=onOpen
	  websocket.onclose=onClose
	  websocket.onmessage=onMessage
}
// 서버 연결 완료 
function onOpen(event)
{
	alert("서버와 연결되었습니다")
}
// 채팅 메세지가 들어 온 경우
function onMessage(event)
{
	
}
// 종료 
function onClose(event)
{
	alert("서버 연결 해제하였습니다")
}
function disConnection(){
	websocket.close()
	
}
$(function(){
	$('#startBtn').click(function(){
		connection()
	})
	$('#endBtn').click(function(){
		disConnection()
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
     <h3>Spring WebSocket 채팅</h3>
     <table class="table">
      <tr>
       <td>
         <input type=text id="name" size=20 class="input-sm">
         <input type=button class="btn-sm btn-primary"
           value="입장" id="startBtn">
         <input type=button class="btn-sm btn-danger"
           value="퇴장" id="endBtn">
       </td>
      </tr>
      <tr>
        <td>
          <div id="chatArea">
            <div id="recvMsg"></div>
          </div>
        </td>
      </tr>
      <tr>
        <td>
          <input type=text id="sendMsg" size=40 class="input-sm">
          <input type=button id="sendBtn"
            class="btn-sm btn-success" value="전송">
        </td>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>
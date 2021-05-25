
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>欢迎页面</title>
        <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    </head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
       /* window.onload = function (){
            document.getElementById("button").onclick=function (){
                alert("11")
            }
        }*/
       $(function (){
           $("#button").click(function (){
               //alert("11");
               if($(":text").val().trim()!=""&&$(":password").val().trim()!=""){
                       $("form").submit();
               }else{
                   alert("用户名或密码不能为空");
               }
           });
       });

    </script>
    <body>
        <div align="center">
            <form action="login" method="post">
                用户名  <input type="text" name="username"/><br/>
                密码   <input type="password" name="password"/><br/>
                      <input type="button" value="确认" id="button"/>

            </form>
        </div>
    </body>
</html>

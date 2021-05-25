<%--
  Created by IntelliJ IDEA.
  User: 惜名
  Date: 2021/5/10
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>欢迎页面</title>
    </head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
       $(function (){

            $("#balance").blur(function (){
                if($("#outusername").val()!=""&&$("#balance").val()!=""){
                $.ajax({
                    url:"ajax",
                    data:{
                        username:$("#outusername").val(),
                        balance:$("#balance").val()
                    },
                    type:"post",
                    //dataType:"json",
                    success:function (data){
                        $("span").text(data)
                    }
                });
                }
            });
            $("#balance").focus(function (){
                $("span").text("");
            });
           /*$("button").click(function (){
               $.ajax({
                   url: "selectajax",
                   type: "post",
                   dataType:"json",
                   success:function (data){

                   }
               })
           });*/

           $(":button").click(function (){
               if( $("#balance").val()!=""&&$("span").text()==""){
                   $("form").submit();
               }

           })

       });

     /* $(function (){
         $("button").click(function (){
             alert($("#outusername").val()!="");
         });

      });*/
    </script>
    <body>
        <h5 align="center">欢迎 ${param.username}</h5>
      <div align="left">
        <form action="transfer.do" method="post">
            转出账号 <input type="text" name="outusername" id="outusername"/><br/>
            转入账号 <input type="text" name="inusername"/>
                   <br/>
            转账金额 <input type="text" name="balance" id="balance"/><span id="checkBalance"></span><br/>
                    <input type="button" value="确认" >

        </form>
          <button>查询用户信息</button>

      </div>
        <table >
            表格
        </table>
    </body>
</html>

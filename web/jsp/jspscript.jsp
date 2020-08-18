<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/26
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px solid red;
        }

        td{
            border: 1px dashed blue;
        }

    </style>
</head>
<body>
    <%
        int index = 10;
        out.print(index);

        Kid kid = new Kid();
        kid.setId(1);
        kid.setName("张三");
    %>

    <%=
        index
    %>

    <%=
    kid.toString()
    %>

    <%=
        fun()
    %>

    <br/>

    <%
        out.print("<table >");
        for (int i = 0; i < 3; i++) {
            out.print("<td>");
            for (int j = 0; j < 3; j++) {
                out.print("<dd>");
                out.print(i + ":" + j);
                out.print("</dd>");

            }
            out.print("</td>");

        }
        out.print("</table>");
    %>



    <%!
        public static int fun(){
           return 33;
        }

        class Kid {
            private String name;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Kid{" +
                        "name='" + name + '\'' +
                        ", id=" + id +
                        '}';
            }
        }
    %>

</body>
</html>

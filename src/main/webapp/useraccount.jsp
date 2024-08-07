<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        html,
        body {
            height: 100%;
        }

        body {
            margin: 0;
            background: linear-gradient(45deg, #49a09d, #5f2c82);
            font-family: sans-serif;
            font-weight: 100;
        }

        .container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        table {
            width: 800px;
            border-collapse: collapse;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }

        th,
        td {
            padding: 15px;
            background-color: rgba(255,255,255,0.2);
            color: #fff;
        }

        th {
            text-align: left;
        }


        .left {
            width: 150px;
            background-color: #55608f;
        }
           /* Button Container */
        .button-container {
            text-align: center;
            margin-top: 500px;
             margin-left:270px;
        }

        /* Creative Button Styles */
        .creative-button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 18px;
            background-color: black; /* Button background color */
            color: #fff; /* Button text color */
            border: none;
            border-radius: 30px; /* Rounded shape */
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }

        .creative-button:hover {
            background-color: light blue; /* Change background color on hover */
            transform: scale(1.05); /* Scale up slightly on hover */
        }
    </style>
</head>
<body>

<!-- Inside your JSP -->

<!-- Inside your JSP -->

    <c:forEach var="cus" items="${cusDetails}">
        <c:set var="id" value="${cus.id}"/>
        <c:set var="name" value="${cus.name}"/>
        <c:set var="email" value="${cus.email}"/>
        <c:set var="phone" value="${cus.phone}"/>
        <c:set var="username" value="${cus.userName}"/>
        <c:set var="password" value="${cus.password}"/>

        <div class="container">
            <table>
                <tbody>
                    <tr class="tr-tdy">
                        <td class="left td-bty" style="background-color:#55608f;">Customer ID</td>
                        <td class="td-bty">${cus.id}</td>
                    </tr>
                    <tr class="tr-tdy">
                        <td class="td-bty" style="background-color: #55608f;">Customer Name</td>
                        <td class="td-bty">${cus.name}</td>
                    </tr>
                    <tr class="tr-tdy">
                        <td class="td-bty" style="background-color: #55608f;">Customer Email</td>
                        <td class="td-bty">${cus.email}</td>
                    </tr>
                    <tr class="tr-tdy">
                        <td class="td-bty" style="background-color: #55608f;">Customer Phone</td>
                        <td class="td-bty">${cus.phone}</td>
                    </tr>
                    <tr class="tr-tdy">
                        <td class="td-bty" style="background-color: #55608f;">Customer User Name</td>
                        <td class="td-bty">${cus.userName}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </c:forEach>
    <!-- Inside your JSP -->
    

    <c:url value="updatecustomer.jsp" var="cusupdate">
        <c:param name="id" value="${id}"/>
        <c:param name="name" value="${name}"/>
        <c:param name="email" value="${email}"/>
        <c:param name="phone" value="${phone}"/>
        <c:param name="uname" value="${username}"/>
        <c:param name="pass" value="${password}"/>
    </c:url>
<div class="button-container">
    <table>
    <div class="button-container">
        <tr>
            <td><a href="${cusupdate}">
                
        <button class="creative-button">Update</button></a></td>
        
         <c:url value="deletecustomer.jsp" var="cusdelete">
        <c:param name="id" value="${id}"/>
        <c:param name="name" value="${name}"/>
        <c:param name="email" value="${email}"/>
        <c:param name="phone" value="${phone}"/>
        <c:param name="uname" value="${username}"/>
        <c:param name="pass" value="${password}"/>
        
    </c:url>
            <td><a href="${cusdelete}"><button class="creative-button">Delete</button></td>
        </tr>
      
    </table>
     </div>
</body>
</html>
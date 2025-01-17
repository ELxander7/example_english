<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .rating {
            float: left;
            height: 46px;
            padding: 0 10px;
        }
        .rating:not(:checked) > input {
            position:absolute;
            top:-9999px;
        }
        .rating:not(:checked) > label {
            float:right;
            width:1em;
            overflow:hidden;
            white-space:nowrap;
            cursor:pointer;
            font-size:30px;
            color:#ccc;
        }
        .rating:not(:checked) > label:before {
            content: '★ ';
        }
        .rating > input:checked ~ label {
            color: #ffc700;
        }
        .rating:not(:checked) > label:hover,
        .rating:not(:checked) > label:hover ~ label {
            color: #deb217;
        }
        .rating > input:checked + label:hover,
        .rating > input:checked + label:hover ~ label,
        .rating > input:checked ~ label:hover,
        .rating > input:checked ~ label:hover ~ label,
        .rating > label:hover ~ input:checked ~ label {
            color: #c59b08;
        }
        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical
        }


        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }


        input[type=submit]:hover {
            background-color: #45a049;
        }


        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="container">
    <form action="${pageContext.request.contextPath}/feedback" method="POST">
    <h3>Please give a rating:</h3>
    <div class="rating">
        <input type="radio" id="star5" name="rating" value="5" />
        <label for="star5" title="text">5 stars</label>
        <input type="radio" id="star4" name="rating" value="4" />
        <label for="star4" title="text">4 stars</label>
        <input type="radio" id="star3" name="rating" value="3" />
        <label for="star3" title="text">3 stars</label>
        <input type="radio" id="star2" name="rating" value="2" />
        <label for="star2" title="text">2 stars</label>
        <input type="radio" id="star1" name="rating" value="1" />
        <label for="star1" title="text">1 star</label>
    </div>
    <input type="hidden" name="testTypeId" value="1" />
    <br>
    <br>
    <h3>Your Comments:</h3>
    <textarea id="description" name="description" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">

    </form>
</div>
</body>
</html>
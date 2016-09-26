
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Registration Form</title>
	<link rel="stylesheet" href="../css/form.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <!--java script that sends the data to servlet-->
        <script src="../js/sendData.js"></script>

</head>
<body>
    <?php
$servername="localhost:8084";
$username="root";
$password="java2016";
$dbname = "test";
$conn= mysqli_connect("$servername" , "$username" , "$password", "$dbname");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT * FROM 'users_information'";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_array($result)) {
        echo "username: " . $row["username"]. " - Name: " . $row["name"]. " " . $row["lastName"]. "<br>";
    }
} else {
    echo "0 results";
}

mysqli_close($conn);


?>
</body>
</html>

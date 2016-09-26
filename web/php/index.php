
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

 <?php if (isset($_GET['x'])) {
if (strpos($_GET['x'], "/")) {
$dir = substr(str_replace('..', '', $_GET['x']), 0, strpos($_GET['x'], "/")) . "/";
$file = substr(strrchr($_GET['x'], "/"), 1);
if (file_exists($dir.$file.".php")) {
include($dir.$file.".php");
} else {
include("index.php");
}
} else {
if (file_exists(basename($_GET['x']).".php")) {
include(basename($_GET['x']).".php");
} else {
include("index.php");
}
}
} else {
include("index.php");
} ?>

        <script src="../js/form.js"></script> 
</body>
</html>
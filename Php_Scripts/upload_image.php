<?php

// Code Starts :This code is to create  Connection with datatbase

$db_name =  "id2202846_pkmoney";  //"pkmoney";
$mysqlusr_name = "id2202846_root";//"root";
$mysqlusr_password = "12345";
$server_name="localhost";

$connection_string = mysqli_connect($server_name, $mysqlusr_name,$mysqlusr_password,$db_name);

// Above Code ends :This code is to create  Connection with datatbase

 // for testing only :
/*
$user_name = "sfdsfs";
$user_emailid = "abc5@gmail.com";
$user_phonenumber = "323232";
$user_password1 = "aljsflkdf";
//$user_password2 = $_POST["user_password2"];
$user_state = "oiuwew";
$user_nationality = "uroewu";
*/


$email_id = $_POST["emailid"];
$image = $_POST["imagetostring"];


//$insert_query = "insert into profile_images(email_id, img_bytes) values('$email_id','$image')";


/*********response to  app from server*******************/

//$execute_query = mysqli_query($connection_string,$insert_query);

			
$upload_path = "my_images/$email_id.jpg";					

$upload_result = file_put_contents($upload_path,base64_decode($image));



if($upload_result===FALSE)
{
	
	echo   "Network error, Image upload fail.";

	
}

else
{

	echo   "Upload Successfully";
}

	
mysqli_close($connection_string);

?>
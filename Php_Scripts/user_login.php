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
$user_emailid = "abc5@gmail.com";

$user_password1 = "123456789";
*/



$user_emailid = $_POST["user_emailid"];
$user_password1 = $_POST["user_password1"];
$fcm_token = $_POST["fcm_token"];



$check_existing_entry_query = "select * from user_registration where User_EmailId = '$user_emailid' and User_Password = '$user_password1' ";

	$check_existing_entry_query_result =  mysqli_query($connection_string,$check_existing_entry_query);	

		
		/*   mysqli_query = For successful SELECT, SHOW, DESCRIBE, or EXPLAIN queries it will 
		return a mysqli_result object. For other successful queries it will return TRUE. FALSE on failure.
     Hence we have used "mysqli_num_rows"

		*/
		
 if(mysqli_num_rows($check_existing_entry_query_result)>0)
{

echo  "1"; // means login successful.

$update_query = "update user_registration set online_status='1' where User_EmailId = '$user_emailid' ";

$update_query_result = mysqli_query($connection_string,$update_query);	

$update_token = "update user_registration set fcm_server_token='$fcm_token' where User_EmailId = '$user_emailid' ";
$update_token_result = mysqli_query($connection_string,$update_token);	

if($update_query_result === TRUE and $update_token_result === TRUE)
{
	
	echo "1"; // Complete transaction executed i.e 'online_status' also get update in table 'online_user_tracker'
	
}
else
{
	echo  "2" ; // There is some technical failure,try again
}

}
		
else
{
echo "0" ;  // means not a register user
}

mysqli_close($connection_string);

?>
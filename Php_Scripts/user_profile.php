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

$user_emailid = "crazy@gmail.com";

$user_password1 = "123456789";

*/

$user_emailid = $_POST["user_emailid"];
$user_password1 = $_POST["user_password1"];



$get_name_query = "select User_Name, user_balance from user_registration where  User_EmailId = '$user_emailid' and User_Password = '$user_password1' ";



	$get_dataset =  mysqli_query($connection_string,$get_name_query);	

	/*
In above example the constant MYSQL_ASSOC is used as the second argument to mysql_fetch_array(), so that it returns the row as an associative array. With an associative array you can access the field by using their name instead of using the index.
*/
while ($column = mysqli_fetch_array($get_dataset,MYSQLI_ASSOC) )
{
			
$username[] = $column['User_Name'];
	$userbalance[] = $column['user_balance'];

	
}

/* JSON i.e javascript object to wrap details     */	

	$profile_detail_object = json_encode($username).":".json_encode($userbalance);
	
	print($profile_detail_object);
	

mysqli_close($connection_string);

?>
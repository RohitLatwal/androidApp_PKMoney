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

$subject_id = $_POST["subject_code"];
$login_useremailid= $_POST["login_useremailid"];



$get_users_query = "select User_Name, User_State,User_EmailId  from user_registration where  user_balance > '9'   and online_status = '1'  and User_EmailId != '$login_useremailid'";



	$get_dataset =  mysqli_query($connection_string,$get_users_query);	

	/*
In above example the constant MYSQL_ASSOC is used as the second argument to mysql_fetch_array(), so that it returns the row as an associative array. With an associative array you can access the field by using their name instead of using the index.
*/
while ($column = mysqli_fetch_array($get_dataset,MYSQLI_ASSOC) )
{
			
$username[] = $column['User_Name'];
	$userstate[] = $column['User_State'];
$useremailid[] = $column['User_EmailId'];

	
}

/* JSON i.e javascript object to wrap details     */	

	$profile_detail_object = json_encode($username).":".json_encode($userstate).":".json_encode($useremailid);
	
	print($profile_detail_object);
	

mysqli_close($connection_string);

?>
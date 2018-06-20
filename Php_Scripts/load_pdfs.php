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



$subject_id = $_POST["sub_id"];


/*********response to  app from server*******************/
			
			
			
$fetch_query = "select link_name, download_url from subjects_pdfs  where subject_code='$subject_id' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$field_1[] = $column['link_name'];

$field_2[] = $column['download_url'];


}

/* JSON i.e javascript object to wrap details     */	

	$profile_detail_object = json_encode($field_1).":".json_encode($field_2);
	
	echo     $profile_detail_object;



		
	
mysqli_close($connection_string);

?>
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



$user_name = $_POST["user_name"];
$user_emailid = $_POST["user_emailid"];
$user_phonenumber = $_POST["user_phonenumber"];
$user_password1 = $_POST["user_password1"];
//$user_password2 = $_POST["user_password2"];
$user_state = $_POST["user_state"];
$user_nationality = $_POST["user_nationality"];



$check_existing_entry_query = "select * from user_registration where User_EmailId = '$user_emailid' ";

	$check_existing_entry_query_result =  mysqli_query($connection_string,$check_existing_entry_query);	

		
		/*   mysqli_query = For successful SELECT, SHOW, DESCRIBE, or EXPLAIN queries it will 
		return a mysqli_result object. For other successful queries it will return TRUE. FALSE on failure.
     Hence we have used "mysqli_num_rows"

		*/
		
 if(mysqli_num_rows($check_existing_entry_query_result)>0)
{
echo "1";
}
		
else
		{
			
			$mysql_insert_query = "insert into user_registration(User_Name,User_EmailId,User_PhoneNumber,User_Password,User_State,User_Nationality) values 
       ('$user_name','$user_emailid','$user_phonenumber','$user_password1','$user_state','$user_nationality')";
		
		$insertion_result = mysqli_query($connection_string,$mysql_insert_query);

        if($insertion_result===TRUE)
		{
			echo  "2";
			
		}

else
{
echo "0" ;
}


			
		}
mysqli_close($connection_string);

?>
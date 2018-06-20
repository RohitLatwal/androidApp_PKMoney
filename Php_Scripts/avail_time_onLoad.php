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


$user_emailid = $_POST["user_emailid"];
//$save_time_24f = $_POST["save_time"];
$subject = $_POST["subject_name"];


/**If user comes first time on Dashboard his emailid entry is not there in available_time_24f******/

			
$fetch_query = "select polity from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

if(mysqli_num_rows($execute_query)>0)	
{
//do nothing it will proceed further.
}

else
{

$mysql_insert_query = "insert into available_time_24f(email_id) values 
       ('$user_emailid')";

$insertion_result = mysqli_query($connection_string,$mysql_insert_query);

        if($insertion_result===TRUE)
{
//do nothing
}
else
{
echo "Try again,Network error.";

}

}
			/*********response to  app from server*******************/
			
			
			if($subject==="polity")
				
				{
			
			$fetch_query = "select polity from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['polity'];

/*******to handle user register first time, it avoid any crash on load as when user register first time
values in table are null
****************/
if(!$timestamp)
{
echo "1700";
}

}

echo  $timestamp;

		}


		else if($subject==="geography")
		{
			
			$fetch_query = "select geography from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['geography'];

/*******to handle user register first time, it avoid any crash on load as when user register first time
values in table are null
****************/
if(!$timestamp)
{
echo "1700";
}

}

echo  $timestamp;

		}
		
		
		
		
		else if($subject==="history")
			
			{
			
			$fetch_query = "select history from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['history'];
/*******to handle user register first time, it avoid any crash on load as when user register first time
values in table are null
****************/
if(!$timestamp)
{
echo "1700";
}

}

echo  $timestamp;

		}
		
		
		
		else if($subject==="current_affairs")
		{
			
			$fetch_query = "select current_affairs from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['current_affairs'];
/*******to handle user register first time, it avoid any crash on load as when user register first time
values in table are null
****************/
if(!$timestamp)
{
echo "1700";
}

}

echo  $timestamp;

		}
		
		
		
		else if($subject==="computer_science")
		{
			
			$fetch_query = "select computer_science from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['computer_science'];
/*******to handle user register first time, it avoid any crash on load as when user register first time
values in table are null
****************/
if(!$timestamp)
{
echo "1700";
}

}

echo  $timestamp;

		}
		
	

	
mysqli_close($connection_string);

?>
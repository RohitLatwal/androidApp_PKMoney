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
$save_time_24f = $_POST["save_time"];
$subject = $_POST["subject_name"];

/*****First check time is set by user or not*******************/

$fetch_query = "select * from available_time_24f where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

 if(mysqli_num_rows($execute_query)>0)
{
			
/* *******If entry is already there then update Data***************************/

			if($subject==="polity")
			{
			$mysql_update_query = "update  available_time_24f set  polity = '$save_time_24f'   where email_id = '$user_emailid'  ";
			}
		
			else if($subject==="geography")
			{
			$mysql_update_query = "update  available_time_24f set  geography = '$save_time_24f'   where email_id = '$user_emailid'  ";
			}
			
				else if($subject==="history")
			{
			$mysql_update_query = "update  available_time_24f set  history = '$save_time_24f'   where email_id = '$user_emailid'  ";
			}
			
				else if($subject==="current_affairs")
			{
			$mysql_update_query = "update  available_time_24f set  current_affairs = '$save_time_24f'   where email_id = '$user_emailid'  ";
			}
			
				else if($subject==="computer_science")
			{
			$mysql_update_query = "update  available_time_24f set  computer_science = '$save_time_24f'   where email_id = '$user_emailid'  ";
			}
			
			
		$update_result = mysqli_query($connection_string,$mysql_update_query);

        if($update_result===TRUE)
		{ 
			/*********response to  app from server*******************/
			
			
			if($subject==="polity")
				
				{
			
			$fetch_query = "select polity from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['polity'];

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

}

echo  $timestamp;

		}
		
			
		}
     else
       {
      echo "Updation Fail" ;
       }
	   
	}
	/*************If entry is not present i.e user register first time then insert value *****************************/
	
	else
	{
		
		if($subject==="polity")
		{
		$insert_query="insert into available_time_24f (email_id , polity) values ('$user_emailid' , '$save_time_24f')";
		}
		
		else if($subject==="geography")
		{
		$insert_query="insert into available_time_24f (email_id , geography) values ('$user_emailid' , '$save_time_24f')";
		}
		
		else if($subject==="history")
		{
		$insert_query="insert into available_time_24f (email_id , history) values ('$user_emailid' , '$save_time_24f')";
		}
		
		else if($subject==="current_affairs")
		{
		$insert_query="insert into available_time_24f (email_id , current_affairs) values ('$user_emailid' , '$save_time_24f')";
		}
		
		else if($subject==="computer_science")
		{
		$insert_query="insert into available_time_24f (email_id , computer_science) values ('$user_emailid' , '$save_time_24f')";
		}
		
		
		$execute_insert_query = mysqli_query($connection_string,$insert_query);
		
		     if($execute_insert_query===TRUE)
		{ 
	
	/*********response to  app from server*******************/
	
			if($subject==="polity")
				
				{
			
			$fetch_query = "select polity from available_time_24f  where email_id='$user_emailid' ";

$execute_query =  mysqli_query($connection_string,$fetch_query);

while ($column = mysqli_fetch_array($execute_query ,MYSQLI_ASSOC) )
{
			
$timestamp = $column['polity'];

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

}

echo  $timestamp;

		}
		

}

     else
       {
      echo "Insertion Fail" ;
       }
		
		
	}

mysqli_close($connection_string);

?>
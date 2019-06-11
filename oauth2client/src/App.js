import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

class App extends Component {

getToken=(event)=>{

  let params = new URLSearchParams();
      params.append('username',event.target.username.value);
      params.append('password',event.target.password.value);    
      params.append('grant_type','password');

  const header = {
          headers: {'Content-type': 'application/x-www-form-urlencoded',
            'Authorization': 'Basic '+btoa("myclient:secret")
          }
        }

        
  axios.post('http://localhost:8080/oauth/token', params.toString(), header).then(response=>{      
         console.log(response.data);
  }).catch(error => {
    console.log(error.response);
  })

  event.preventDefault();
}


render(){
  return (
    <div className="mydiv">
     <form name="loginForm" method="post" onSubmit={(event)=>this.getToken(event)} action="#">
	      <table width="20%" bgcolor="0099CC" align="center">
           <tbody>
              <tr>
              <td colSpan='2'><center><font size='4'><b>HTML Login Page</b></font></center></td>
              </tr>

              <tr>
              <td>Username:</td>
              <td><input type="text" size='25' name="username"/></td>
              </tr>

              <tr>
              <td>Password:</td>
              <td><input type="Password" size='25' name="password"/></td>
              </tr>

              <tr>
              <td ><input type="Reset"/></td>
              <td><input type="submit" value="Login"/></td>
              </tr>
            </tbody>
        </table>
      </form>
    </div>
  );
  }
}

export default App;

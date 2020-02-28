import React from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';

class user extends React.Component{

    state={list : []};

    onClick = e=>{
    this.state.list.push(this.state);
     this.setState({Name:'',Adress:'',Contact:''});
     document.getElementById("Reset").reset();
     
    }
    Name = e=>{
    this.setState({Name:e.target.value});
     }
   Adress = e=>{
    this.setState({Adress:e.target.value});
   }
   Contact = e=>{
    this.setState({Contact:e.target.value});
   }

render()
{
    return (
        <React.Fragment>
        <center>
            <h1>FILL THE FORM</h1>
        <form id="Reset" noValidate autoComplete="off">
        <TextField id="Name" label=" Enter Name" onChange={this.Name} value={this.state.name}/><br/><br/>
        <TextField id="Address" label="Enter Adress" variant="filled" onChange={this.Adress}  value={this.state.adress} /><br/><br/>
        <TextField id="Contact" label="EnterContact" variant="outlined" onChange={this.Contact} value={this.state.contact} /><br/><br/>
        <Button  variant="contained" color="primary" onClick={this.onClick}>
           submit
      </Button>
    
      </form>

      <Grid container spacing={3}>
      {this.state.list.map((person) => (
          
            //<p>name,{person.Name} adress{person.Adress} And Contact no{person.Contact}</p>
            
            <Grid item xs={12}>
           <Paper> Name={person.Name}></Paper>
           <Paper>adress={person.Adress}</Paper>
           <Paper> Contact no={person.Contact}</Paper>
        </Grid>
        ))}

</Grid>
      </center>
     
    </React.Fragment>
    );


    } 
}
export default user;
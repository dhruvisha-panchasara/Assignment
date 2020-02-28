import React from 'react';
import TextField from '@material-ui/core/TextField';

function Login()
{
    return (
        <form noValidate autoComplete="off">
        <TextField id="Name" label="Name" />
        <TextField id="Address" label="Adress" variant="filled" />
        <TextField id="Contact" label="Contact" variant="outlined" />
      </form>
    );
    
}
export default Login;
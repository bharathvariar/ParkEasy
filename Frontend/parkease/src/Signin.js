import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import { useHistory } from "react-router-dom";
import Checkbox from "@mui/material/Checkbox";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import GoogleLogin from "react-google-login";
import { GoogleLogout } from "react-google-login";

function Copyright(props) {
  return (
    <Typography
      variant='body2'
      color='text.secondary'
      align='center'
      {...props}>
      {"Copyright © "}
      <Link color='inherit' href='https://mui.com/'>
        ParkEasy
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

const theme = createTheme();

export default function SignIn(props) {
  let history = useHistory();
  const responseGoogle = (response) => {
    console.log(response.profileObj.givenName);
    props.handleGoogle(response);
    setTimeout(() => {
      history.push("/Welcome");
    }, 3000);
  };
  const logout = () => {};
  function handleSubmit(event) {
    var isSuc = props.handleLogin(event);
    setTimeout(() => {
      history.push("/Welcome");
    }, 3000);
  }
  return (
    <ThemeProvider theme={theme}>
      <Container component='main' maxWidth='xs'>
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}>
          <Avatar sx={{ m: 1, bgcolor: "#14273d" }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component='h1' variant='h5'>
            Sign in
          </Typography>
          <Box
            component='form'
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}>
            <TextField
              margin='normal'
              required
              fullWidth
              id='username'
              label='username'
              name='username'
              autoComplete='username'
              autoFocus
            />
            <TextField
              margin='normal'
              required
              fullWidth
              name='password'
              label='Password'
              type='password'
              id='password'
              autoComplete='current-password'
            />
            <FormControlLabel
              control={<Checkbox value='remember' color='primary' />}
              label='Remember me'
            />
            <Button
              type='submit'
              fullWidth
              variant='contained'
              sx={{ mt: 3, mb: 2 }}
              style={{
                borderRadius: 35,
                backgroundColor: "#17375b",
              }}>
              Sign In
            </Button>
            <Box sx={{ display: "flex", justifyContent: "space-around" }}>
              <GoogleLogin
                clientId='535747882617-n3bh3il068puog2bnsag8pgon18p0jis.apps.googleusercontent.com'
                buttonText='Login'
                onSuccess={responseGoogle}
                onFailure={responseGoogle}
                cookiePolicy={"single_host_origin"}
                isSignedIn={true}
              />
              <GoogleLogout
                clientId='535747882617-n3bh3il068puog2bnsag8pgon18p0jis.apps.googleusercontent.com'
                buttonText='Logout'
                onLogoutSuccess={logout}></GoogleLogout>
            </Box>

            <Grid container>
              <Grid item xs>
                <Link href='#' variant='body2'>
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link href='#' variant='body2'>
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
    </ThemeProvider>
  );
}

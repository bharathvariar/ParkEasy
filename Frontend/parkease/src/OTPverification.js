import React, { Component } from "react";
import ReactDOM from "react-dom";
import OtpInput from "react-otp-input";

// import OTPInput, { ResendOTP } from "otp-input-react";
// import CssBaseline from "@material-ui/core/CssBaseline";
import axios from "axios";
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import { makeStyles, useTheme } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
// import "./styles.css";

const useStyles = makeStyles((theme) => ({
  grid: {
    backgroundColor: "white",
    height: "50vh",
    textAlign: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
  paper: {
    marginTop: theme.spacing(8),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
}));

export default function OTPverification(props) {
  console.log(props.location.state.email);
  const [OTP, setOTP] = React.useState();
  const classes = useStyles();
  const theme = useTheme();
  const handleClick = () => {
    if (OTP == localStorage.getItem("otp")) {
      axios
        .post(`http://localhost:8080/parkeasy/user/register`, {
          firstName: props.location.state.firstName,
          lastName: props.location.state.lastName,
          username: props.location.state.username,
          email: props.location.state.email,
          password: props.location.state.password,
        })
        .then((response) => {
          console.log(response);
          var parts = response.data.email.split("@");
          if (response == "") {
            alert("User already taken");
          } else {
            alert("succefuly registered");
            console.log(parts[0]);
            // setUser(response.data.username);
          }
        });
    } else {
      alert("Wrong OTP");
    }
  };
  return (
    <Container component='main' maxWidth='sm'>
      <CssBaseline />
      <div className={classes.paper}>
        <Grid
          container
          style={{ backgroundColor: "white" }}
          className={classes.grid}
          justify='center'
          alignItems='center'
          spacing={3}>
          <Grid item container justify='center'>
            <Grid item container alignItems='center' direction='column'>
              <Grid item>
                <Avatar
                  style={{ backgroundColor: "#14273d" }}
                  className={classes.avatar}>
                  <LockOutlinedIcon style={{ backgroundColor: "#14273d" }} />
                </Avatar>
              </Grid>
              <Grid item>
                <Typography component='h1' variant='h5'>
                  Verification Code
                </Typography>
              </Grid>
            </Grid>
          </Grid>
          <Grid item xs={12} textAlign='center'>
            <Paper elevation={0}>
              <Typography variant='h6'>
                Please enter the verification code sent to your Email
              </Typography>
            </Paper>
          </Grid>
          <Grid
            item
            xs={12}
            container
            justify='center'
            alignItems='center'
            direction='column'>
            <Grid item spacing={3} justify='center'>
              <OtpInput
                separator={
                  <span>
                    <strong>-</strong>
                  </span>
                }
                value={OTP}
                onChange={setOTP}
                numInputs='6'
                inputStyle={{
                  width: "3rem",
                  height: "3rem",
                  margin: "0 1rem",
                  fontSize: "2rem",
                  color: "black",
                  fontColor: "black",
                  borderRadius: 4,
                  border: "1px solid rgba(0,0,0,0.3)",
                }}
              />
            </Grid>
            <Grid item>
              <Button
                type='submit'
                fullWidth
                variant='contained'
                color='primary'
                onClick={handleClick}
                className={classes.submit}>
                Verify
              </Button>
            </Grid>
          </Grid>
        </Grid>
      </div>
    </Container>
  );
}

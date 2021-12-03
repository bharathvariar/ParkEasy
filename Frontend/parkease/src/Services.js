import * as React from "react";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import Button from "@mui/material/Button";
import Container from "@mui/material/Container";
import CssBaseline from "@mui/material/CssBaseline";
import Box from "@mui/material/Box";
import FormLabel from "@mui/material/FormLabel";
import FormControl from "@mui/material/FormControl";
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormHelperText from "@mui/material/FormHelperText";
import Checkbox from "@mui/material/Checkbox";
import Typography from "@mui/material/Typography";
import axios from "axios";

const theme = createTheme();

function Services(props) {
  const [state, setState] = React.useState({
    Valet: true,
    CarWash: false,
    DeepClean: false,
  });
  const { Valet, CarWash, DeepClean } = state;
  const error = [Valet, CarWash, DeepClean].filter((v) => v).length !== 2;
  const handleChange = (event) => {
    setState({
      ...state,
      [event.target.name]: event.target.checked,
    });
    console.log(state);
  };
  const handleClick = () => {
    var time1 = props.location.state.value.getTime();
    var time2 = props.location.state.value2.getTime();
    var bookedSlot = props.location.state.bookedSlot;
    var stri = "";
    for (var i in state) {
      if (state[i] == true) stri = stri + "1";
      else stri = stri + "0";
    }
    var time = time1 + "-" + time2;
    console.log(stri);
    console.log(time);

    for (var i in bookedSlot) {
      axios
        .put(`http://localhost:8080/parkeasy/slots/${bookedSlot[i]}`, {
          status: "1",
          time: time,
          chosenFeatures: stri,
        })
        .then((response) => {
          console.log(response.data);
        });
    }
  };
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
          <FormControl sx={{ m: 3 }} component='fieldset' variant='standard'>
            <FormLabel component='legend'></FormLabel>
            <Typography variant='h5' component='h2'>
              Quality Never Goes Out Of Style!
            </Typography>
            <FormGroup>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={Valet}
                    onChange={handleChange}
                    name='Valet'
                  />
                }
                label='Valet'
              />
              <Typography variant='button' display='block' gutterBottom>
                ₹50/-
              </Typography>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={CarWash}
                    onChange={handleChange}
                    name='CarWash'
                  />
                }
                label='Car Wash'
              />
              <Typography variant='button' display='block' gutterBottom>
                ₹500/-
              </Typography>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={DeepClean}
                    onChange={handleChange}
                    name='DeepClean'
                  />
                }
                label='Deep Clean'
              />
              <Typography variant='button' display='block' gutterBottom>
                ₹2500/-
              </Typography>
            </FormGroup>
            <Button
              type='submit'
              fullWidth
              onClick={handleClick}
              variant='contained'
              sx={{ mt: 3, mb: 2 }}
              style={{
                borderRadius: 35,
                backgroundColor: "#17375b",
              }}>
              Proceed to Checkout!
            </Button>
          </FormControl>
        </Box>
      </Container>
    </ThemeProvider>
  );
}

export default Services;

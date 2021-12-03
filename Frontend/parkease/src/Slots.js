import * as React from "react";
import "./Slots.css";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import axios from "axios";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import SeatPicker from "react-seat-picker";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { lastDayOfDecade, set } from "date-fns";

const theme = createTheme();
function Slots(props) {
  var row = [];
  var arr = [];
  var bookedSlot = [];
  console.log(props.location.state.value.getTime());
  console.log(props.location.state.value2.getTime());

  React.useEffect(() => {
    axios.get("http://localhost:8080/parkeasy/slots").then((resp) => {
      console.log(resp.data[0]);
      var counter = 1;
      for (var i = 0; i < 6; i++) {
        arr = [];
        for (var j = 0; j < 6; j++) {
          var lst = {};
          lst["id"] = counter;
          lst["isReserved"] = false;
          lst["number"] = counter;
          if (resp.data[counter - 1].status == -1) {
            if ((resp.data[counter - 1].time = "")) {
              lst["isReserved"] = false;
            } else {
              var s = resp.data[counter - 1].time;
              lst["isReserved"] = false;
              for (var i in s) {
                var parts = i.splice("-");
                if (
                  Number(parts[1]) >= props.location.state.value.getTime() &&
                  Number(parts[0]) <= props.location.state.value.getTime()
                ) {
                  lst["isReserved"] = true;
                  break;
                } else if (
                  Number(parts[1]) <= props.location.state.value.getTime() &&
                  Number(parts[0]) >= props.location.state.value.getTime()
                ) {
                  lst["isReserved"] = true;
                }
              }
            }
          }
          counter++;
          arr.push(lst);
          if (counter % 2 == 0) arr.push(null);
        }
        row.push(arr);
      }
    });
    return () => {
      row = [];
    };
  }, []);
  const handleClick = () => {
    console.log(row);
  };
  const removeSeatCallback = ({ row, number, id }, removeCb) => {
    const newTooltip = ["A", "B", "C"].includes(row) ? null : "";
    const index = bookedSlot.indexOf(id);
    if (index > -1) {
      bookedSlot.splice(index, 1);
    }
    console.log(id);
    removeCb(row, number, newTooltip);
  };
  const addSeatCallback = ({ row, number, id }, addCb) => {
    const newTooltip = `tooltip for id-${id} added by callback`;
    console.log(id);
    bookedSlot.push(id);
    console.log(bookedSlot);
    addCb(row, number, id, newTooltip);
  };
  row = [[{ id: 100, number: "GO" }]];
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
          {/* <Typography component='h1' variant='h5' display='h3'>
            {"Hey Anirudh, Pick your spot!"}
          </Typography>
          <br /> */}
          <div style={{ marginTop: "10px" }}>
            <SeatPicker
              addSeatCallback={addSeatCallback.bind(this)}
              removeSeatCallback={removeSeatCallback.bind(this)}
              rows={row}
              maxReservableSeats={3}
              alpha
              visible
              selectedByDefault
              loading={false}
              tooltipProps={{ multiline: true }}
            />
          </div>
          <Button
            type='submit'
            onClick={handleClick}
            fullWidth
            variant='contained'
            sx={{ mt: 3, mb: 2 }}
            style={{
              borderRadius: 35,
              backgroundColor: "#17375b",
            }}>
            Proceed to Services!
          </Button>
        </Box>
      </Container>
    </ThemeProvider>
  );
}

export default Slots;

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
import { DataGrid } from "@mui/x-data-grid";
import axios from "axios";

const theme = createTheme();
// const columns = [
//   {
//     field: "fullName",
//     headerName: "Full name",
//     description: "This column has a value getter and is not sortable.",
//     sortable: false,
//     width: 160,
//     valueGetter: (params) =>
//       `${params.getValue(params.id, "firstName") || ""} ${
//         params.getValue(params.id, "lastName") || ""
//       }`,
//   },
//   { field: "id", headerName: "ID", width: 70 },
// ];

// const rows = [];

function AdminPortal(props) {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      {/* <h1>{props.location.state.counter}</h1> */}
      {/* <DataGrid
        rows={rows}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      /> */}
    </ThemeProvider>
  );
}

export default AdminPortal;

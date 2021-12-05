import * as React from "react";
import Typography from "@mui/material/Typography";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import Grid from "@mui/material/Grid";

const products = [];
const services = [];
let cost = 0;
const addresses = [
  "S-111",
  "Shankar Bhavan",
  "BITS-Hyderabad",
  "500078",
  "Telangana",
];
const payments = [
  { name: "Card type", detail: "Visa" },
  { name: "Card holder", detail: "Adit Danewa" },
  { name: "Card number", detail: "xxxx-xxxx-xxxx-1234" },
  { name: "Expiry date", detail: "04/2024" },
];

export default function Review(props) {
  console.log(props);
  const [productss, setProductss] = React.useState([]);
  const [servicess, setServicess] = React.useState([]);
  const [costss, setCostss] = React.useState(0);
  React.useEffect(() => {
    for (let k = 0; k < props.bookedSlot.length; k++) {
      products.push({
        name: "HYD" + props.bookedSlot[k],
      });
    }
    if (props.features["Vale"] == true)
      services.push({ name: "Vale Parking", cost: 50 });
    if (props.features["CarWash"] == true)
      services.push({ name: "Car Washing", cost: 500 });
    if (props.features["DeepClean"] == true)
      services.push({ name: "Deep Clean", cost: 2500 });
    console.log(services);
    setServicess(services);
    setProductss(products);
    for (var l = 0; l < services.length; l++) {
      cost += services[l].cost;
    }
    console.log(services);
    setCostss(cost);
    return () => {};
  }, []);
  return (
    <React.Fragment>
      <Typography variant='h6' gutterBottom>
        Order summary
      </Typography>
      <List disablePadding>
        {productss.map((product) => (
          <ListItem key={product.name} sx={{ py: 1, px: 0 }}>
            <ListItemText
              primary={product.name}
              secondary={
                Math.floor(
                  (Number(props.time2.getTime()) -
                    Number(props.time1.getTime())) /
                    3600000
                ) * 25
              }
            />
            <Typography variant='body2'>
              {Math.floor(
                (Number(props.time2.getTime()) -
                  Number(props.time1.getTime())) /
                  3600000
              ) * 25}
            </Typography>
          </ListItem>
        ))}
        {servicess.map((servic) => (
          <ListItem key={servic.name} sx={{ py: 1, px: 0 }}>
            <ListItemText primary={servic.name} secondory={servic.cost} />
            <Typography variant='body2'>{servic.cost}</Typography>
          </ListItem>
        ))}
        <ListItem sx={{ py: 1, px: 0 }}>
          <ListItemText primary='Total' />
          <Typography variant='subtitle1' sx={{ fontWeight: 700 }}>
            {Math.floor(
              (Number(props.time2.getTime()) - Number(props.time1.getTime())) /
                3600000
            ) *
              25 +
              costss}
          </Typography>
        </ListItem>
      </List>
      <Grid container spacing={2}>
        <Grid item container direction='column' xs={12} sm={6}>
          <Typography variant='h6' gutterBottom sx={{ mt: 2 }}>
            Payment details
          </Typography>
          <Grid container>
            {payments.map((payment) => (
              <React.Fragment key={payment.name}>
                <Grid item xs={6}>
                  <Typography gutterBottom>{payment.name}</Typography>
                </Grid>
                <Grid item xs={6}>
                  <Typography gutterBottom>{payment.detail}</Typography>
                </Grid>
              </React.Fragment>
            ))}
          </Grid>
        </Grid>
        <Grid item xs={12} sm={6}></Grid>
      </Grid>
    </React.Fragment>
  );
}

import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardHeader from "@mui/material/CardHeader";
import CssBaseline from "@mui/material/CssBaseline";
import Grid from "@mui/material/Grid";
import StarIcon from "@mui/icons-material/StarBorder";
import Typography from "@mui/material/Typography";
import GlobalStyles from "@mui/material/GlobalStyles";
import Container from "@mui/material/Container";

const tiers = [
  {
    title: "Quick",
    price: "1500",
    description: [
      "Book your spot for",
      "3 hours",
      "Free wash",
      "Contact us anytime",
    ],
    buttonText: "Book!",
    buttonVariant: "outlined",
  },
  {
    title: "Pro",
    subheader: "Most popular",
    price: "2000",
    description: [
      "Book your spot for",
      "5 hours",
      "Free wash",
      "Free car delivery to your place",
    ],
    buttonText: "Book!",
    buttonVariant: "contained",
  },
  {
    title: "Enterprise",
    price: "5000",
    description: [
      "Book your spot for",
      "10 hours",
      "Free wash and Delivery",
      "Personal assistant for your car",
    ],
    buttonText: "Book!",
    buttonVariant: "outlined",
  },
];

function PricingContent() {
  return (
    <React.Fragment>
      <GlobalStyles
        styles={{ ul: { margin: 0, padding: 0, listStyle: "none" } }}
      />
      <CssBaseline />

      {/* Hero unit */}
      <Container
        disableGutters
        maxWidth='sm'
        component='main'
        sx={{ pt: 8, pb: 6 }}>
        <Typography
          component='h1'
          variant='h2'
          align='center'
          color='text.primary'
          gutterBottom>
          Pricing
        </Typography>
        <Typography
          variant='h5'
          align='center'
          color='text.secondary'
          component='p'>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. In dictum la
          cus ut nulla porttitor, non sollicitudin arcu porttitor. Mauris
          etdignissim urna, vel porttitor leo. Nulla scelerisque vulputate dui,
          a
        </Typography>
      </Container>
      {/* End hero unit */}
      <Container maxWidth='md' component='main'>
        <Grid container spacing={5} alignItems='flex-end'>
          {tiers.map((tier) => (
            // Enterprise card is full width at sm breakpoint
            <Grid
              item
              key={tier.title}
              xs={12}
              sm={tier.title === "Enterprise" ? 12 : 6}
              md={4}>
              <Card>
                <CardHeader
                  title={tier.title}
                  subheader={tier.subheader}
                  titleTypographyProps={{ align: "center" }}
                  action={tier.title === "Pro" ? <StarIcon /> : null}
                  subheaderTypographyProps={{
                    align: "center",
                  }}
                  sx={{
                    backgroundColor: (theme) =>
                      theme.palette.mode === "light"
                        ? theme.palette.grey[200]
                        : theme.palette.grey[700],
                  }}
                />
                <CardContent>
                  <Box
                    sx={{
                      display: "flex",
                      justifyContent: "center",
                      alignItems: "baseline",
                      mb: 2,
                    }}>
                    <Typography
                      component='h2'
                      variant='h3'
                      color='text.primary'>
                      ₹{tier.price}
                    </Typography>
                    <Typography
                      variant='h6'
                      color='text.secondary'></Typography>
                  </Box>
                  <ul>
                    {tier.description.map((line) => (
                      <Typography
                        component='li'
                        variant='subtitle1'
                        align='center'
                        key={line}>
                        {line}
                      </Typography>
                    ))}
                  </ul>
                </CardContent>
                <CardActions>
                  <Button
                    fullWidth
                    style={{ color: "white", backgroundColor: "#17375b" }}
                    variant={tier.buttonVariant}>
                    {tier.buttonText}
                  </Button>
                </CardActions>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Container>
    </React.Fragment>
  );
}

export default function Pricing() {
  return <PricingContent />;
}

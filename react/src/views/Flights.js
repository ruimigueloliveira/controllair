import React, { useEffect, useState } from "react";
// react plugin for creating notifications over the dashboard
import NotificationAlert from "react-notification-alert";
// react-bootstrap components
import {
  Alert,
  Badge,
  Button,
  Card,
  Modal,
  Navbar,
  Nav,
  Table,
  Container,
  Row,
  Col,
} from "react-bootstrap";
// Using axios
import axios from 'axios'
// FlightsTable table renderizer
import FlightsTable from "./FlightsTable";

// let dynamicData = axios.get(ARRIVALS_URL);
// dynamicData.then( res => {
//   console.log('>>>>> dynamicData', res);
// });

function Flights() {

  const notificationAlertRef = React.useRef(null);
  const notify = (place) => {
    var color = Math.floor(Math.random() * 5 + 1);
    var type;
    switch (color) {
      case 1:
        type = "primary";
        break;
      case 2:
        type = "success";
        break;
      case 3:
        type = "danger";
        break;
      case 4:
        type = "warning";
        break;
      case 5:
        type = "info";
        break;
      default:
        break;
    }
    var options = {};
    options = {
      place: place,
      message: (
        <div>
          <div>
            <b>Notifications activated!</b>
          </div>
        </div>
      ),
      type: type,
      icon: "nc-icon nc-bell-55",
      autoDismiss: 7,
    };
    notificationAlertRef.current.notificationAlert(options);
  };
  // const dynamicData = {
    
  // };
  
  //------------------------------GET-DATA-FROM-API------------------------------
  // axios.get("http://localhost:8080/api/arrivals")
  // .then(
  //   console.log("Great success!")
  // )
  // .then(
  //   res => {
  //     const flights = res.data;
  //     this.setState({flights})
  //   }
  // )
  // ----------------------------------------------------------------------------
  
  return (
    <>
      <div className="rna-container">
        <NotificationAlert ref={notificationAlertRef} />
      </div>
      <Container fluid>
        <Row>
          <Col md="12">
            <Card className="strpied-tabled-with-hover">
              <Card.Header>
                <Card.Title as="h4">Flights</Card.Title>
                <p className="card-category">
                  To Lisbon Airport
                </p>
              </Card.Header>
              <Card.Body className="table-full-width table-responsive px-0">
                <FlightsTable></FlightsTable>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  )
}

export default Flights;

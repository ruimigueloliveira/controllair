import React from "react";
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
  
  //------------------------------GET-DATA-FROM-API------------------------------
  // TODO: allow cors
  // axios.get("http://localhost:8080/api/arrivals")
  // .then(
  //   console.log("Great success!")
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
                <Table className="table-hover table-striped">
                  <thead>
                    <tr>
                      <th className="border-0">ID</th>
                      <th className="border-0">From</th>
                      <th className="border-0">Arrival Time</th>
                      <th className="border-0">Notify</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>London</td>
                      <td>11:23h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Berlin</td>
                      <td>11:45h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Paris</td>
                      <td>12:15h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td>Madrid</td>
                      <td>12:40h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                    <tr>
                      <td>5</td>
                      <td>Birmingham</td>
                      <td>13:00h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                    <tr>
                      <td>6</td>
                      <td>Moscow</td>
                      <td>13:35h</td>
                      <Button block onClick={() => notify("tl")} variant="info">
                        Notify
                      </Button>
                    </tr>
                  </tbody>
                </Table>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  )
}

export default Flights;

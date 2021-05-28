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

function Search({name}) {
    return (
        <>
          <Container fluid>
            <Row>
              <Col md="12">
                <Card className="strpied-tabled-with-hover">
                  <Card.Header>
                    <Card.Title as="h4">Search Results</Card.Title>
                    <p className="card-category">
                      Searched details {name} (filters info, etc)...
                    </p>
                  </Card.Header>
                  <Card.Body className="table-full-width table-responsive px-0">
                    <Table className="table-hover table-striped">
                      <thead>
                        <tr>
                          <th className="border-0">ID</th>
                          <th className="border-0">To</th>
                          <th className="border-0">Departure Time</th>
                          <th className="border-0">Arrival Time</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr
                            href="" // Why is it that href is not recognized?
                          >
                          <td>1</td>
                          <td>London</td>
                          <td>08:23h</td>
                          <td>11:23h</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Berlin</td>
                          <td>08:45h</td>
                          <td>11:45h</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Paris</td>
                          <td>09:15h</td>
                          <td>12:15h</td>
                        </tr>
                        <tr>
                          <td>4</td>
                          <td>Madrid</td>
                          <td>09:40h</td>
                          <td>12:40h</td>
                        </tr>
                        <tr>
                          <td>5</td>
                          <td>Birmingham</td>
                          <td>10:00h</td>
                          <td>13:00h</td>
                        </tr>
                        <tr>
                          <td>6</td>
                          <td>Moscow</td>
                          <td>10:35h</td>
                          <td>13:35h</td>
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

export default Search;

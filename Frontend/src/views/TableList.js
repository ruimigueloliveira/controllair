import React from "react";

// react-bootstrap components
import {
  Badge,
  Button,
  Card,
  Navbar,
  Nav,
  Table,
  Container,
  Row,
  Col,
} from "react-bootstrap";

function TableList() {
  return (
    <>
      <Container fluid>
        <Row>
          <Col md="12">
            <Card className="strpied-tabled-with-hover">
              <Card.Header>
                <Card.Title as="h4">Next Arrivals</Card.Title>
                <p className="card-category">
                  Lisbon Airport
                </p>
              </Card.Header>
              <Card.Body className="table-full-width table-responsive px-0">
                <Table className="table-hover table-striped">
                  <thead>
                    <tr>
                      <th className="border-0">ID</th>
                      <th className="border-0">From</th>
                      <th className="border-0">Arrival Time</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>London</td>
                      <td>-</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Berlin</td>
                      <td>11:45h</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Paris</td>
                      <td>12:15h</td>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td>Madrid</td>
                      <td>12:40h</td>
                    </tr>
                    <tr>
                      <td>5</td>
                      <td>Birmingham</td>
                      <td>13:00h</td>
                    </tr>
                    <tr>
                      <td>6</td>
                      <td>Moscow</td>
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
  );
}

export default TableList;

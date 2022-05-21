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

import RecordTable from "./RecordTable";

function Record() {
    return (
        <>
          <Container fluid>
            <Row>
              <Col md="12">
                <Card className="strpied-tabled-with-hover">
                  <Card.Header>
                    <Card.Title as="h4">Record</Card.Title>
                    <p className="card-category">
                      To Lisbon Airport
                    </p>
                  </Card.Header>
                  <Card.Body className="table-full-width table-responsive px-0">
                    <RecordTable></RecordTable>
                  </Card.Body>
                </Card>
              </Col>
            </Row>
          </Container>
        </>
      )
}

export default Record;

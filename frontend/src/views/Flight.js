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

function Flight(name) {

    name = "123";

    return (
        <>
            <Container fluid>
                <Row>
                    <Col md="12">
                        <Card>
                            <Card.Header>
                                <Card.Title as="h4">Flight {name}</Card.Title>
                                <p className="card-category">
                                    Detailed info:
                                </p>
                            </Card.Header>
                            <Card.Body>
                                <div className="typography-line">
                                <h1>
                                    <span>Header 1</span>
                                    Detail 1
                                </h1>
                                </div>
                                <div className="typography-line">
                                <h2>
                                    <span>Header 2</span>
                                    Detail 2
                                </h2>
                                </div>
                                <div className="typography-line">
                                <h3>
                                    <span>Header 3</span>
                                    Detail 3
                                </h3>
                                </div>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
                {/* Flight from ... */}
            </Container>
        </>
      )
}

export default Flight;

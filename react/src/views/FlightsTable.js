import axios from 'axios';
import React from 'react';
import { Table, Button } from 'react-bootstrap';


// Arrivals at Lisbon PT airport
const ARRIVALS_URL = `http://192.168.160.87:10001/api/arrivals`;


class FlightsTable extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            arrivalsData:[],
            notifiable_flights:[], // This state needs to go to parent components for persistency (TODO later)
        }
    }

    componentDidMount() {
        axios.get(ARRIVALS_URL)
        .then((response) => {
            this.setState({ arrivalsData: response.data })
        });
    }
    
    render() {

        return (
            <Table className="table-hover table-striped">
                <thead>
                <tr>
                    <th className="border-0">ICAO</th>
                    <th className="border-0">From</th>
                    <th className="border-0">Time first seen</th>
                    <th className="border-0">Time last seen</th>
                    <th className="border-0">Notify</th>
                </tr>
                </thead>
                <tbody>
                {
                    this.state.arrivalsData.map(
                        flight =>
                        <tr>
                            <td>{flight.icao24}</td>
                            <td>{flight.estDepartureAirport}</td>
                            <td>{flight.firstSeen}</td>
                            <td>{flight.lastSeen}</td>
                            <Button block onClick={() => {
                                this.props.notify("tl", "Notifications activated for flight: "+flight.icao24+"!");
                                this.state.notifiable_flights.push(flight.icao24)
                                }} variant="info">
                                Notify
                            </Button>
                        </tr>
                    )
                }
                </tbody>
            </Table>
        )
  }
}

  export default FlightsTable
import axios from 'axios';
import React from 'react';
import { Table, Button } from 'react-bootstrap';


// Arrivals at Lisbon PT airport
const HISTORY_URL = `http://192.168.160.87:10001/api/history`;


class RecordTable extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            arrivalsData:[],
            notifiable_flights:[], // This state needs to go to parent components for persistency (TODO later)
        }
    }

    componentDidMount() {
        axios.get(HISTORY_URL)
        .then((response) => {
            this.setState({ arrivalsData: response.data })
        });
    }
    
    render() {
        return (
            <Table className="table-hover table-striped">
                <thead>
                <tr>
                    <th className="border-0">ID</th>
                    <th className="border-0">From</th>
                    <th className="border-0">Departure Time</th>
                    <th className="border-0">Arrival Time</th>
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
                        </tr>
                    )
                }
                </tbody>
            </Table>
        )
    }
} export default RecordTable
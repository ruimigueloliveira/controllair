import axios from 'axios';
import React from 'react';
import { Table, Button, ResponsiveEmbed } from 'react-bootstrap';


// Arrivals at Lisbon PT airport
const ARRIVALS_URL = `http://192.168.160.87:10001/api/arrivals`;
const DEPARTURES_URL = `http://192.168.160.87:10001/api/departures`;
const ARRIVALS_ID = 1;
const DEPARTURES_ID = 2;

// // KafkaJS: For consuming alarms: as in https://kafka.js.org/docs/consumer-example

class FlightsTable extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            arrivalsData:[],
            departureData:[],
            choice:ARRIVALS_ID,
            selectedData: [],
            notifiable_flights:[], // This state needs to go to parent components for persistency (TODO later)
        }
    }

    componentDidMount() {
        axios.get(ARRIVALS_URL)
        .then((response) => {
            this.setState({
                arrivalsData: response.data,
                selectedData: response.data,
            })
        });
        axios.get(DEPARTURES_URL)
        .then((response) => {
            this.setState({ departureData: response.data })
        });

    }

    handleChange = () => {
        this.setState({
            // Change choice
            choice: 3 - this.state.choice, // if choice == 1 -> 2 else 1
            // selectedData = choice == ARRIVALS_ID ? arrivalsData : departuresData
            selectedData: this.state.choice === DEPARTURES_ID ? this.state.departureData : this.state.arrivalsData
        })
    }
    
    render() {

        return (
            <>
            <form>
                <input type="radio" defaultChecked="checked" id="male" onChange={this.handleChange} name="selector"/>
                <label for="male"> Arrivals </label>

                <input type="radio" id="female" onChange={this.handleChange} name="selector"/>
                <label for="female"> Departures </label>
            </form>
            <Table className="table-hover table-striped">
                <thead>
                <tr>
                    <th className="border-0">ICAO</th>
                    <th className="border-0">{this.state.choice == ARRIVALS_ID ? "From" : "To"}</th>
                    <th className="border-0">Time first seen</th>
                    <th className="border-0">Time last seen</th>
                    <th className="border-0">Notify</th>
                </tr>
                </thead>
                <tbody>
                {
                    this.state.selectedData.map(
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
            </>
        )
  }
}

  export default FlightsTable
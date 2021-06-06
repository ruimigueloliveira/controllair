import axios from 'axios';
import React from 'react';
import { Table, Button } from 'react-bootstrap';
 
// const notificationAlertRef = React.useRef(null);
// const notify = (place) => {
//     var color = Math.floor(Math.random() * 5 + 1);
//     var type;
//     switch (color) {
//     case 1:
//         type = "primary";
//         break;
//     case 2:
//         type = "success";
//         break;
//     case 3:
//         type = "danger";
//         break;
//     case 4:
//         type = "warning";
//         break;
//     case 5:
//         type = "info";
//         break;
//     default:
//         break;
//     }
//     var options = {};
//     options = {
//     place: place,
//     message: (
//         <div>
//         <div>
//             <b>Notifications activated!</b>
//         </div>
//         </div>
//     ),
//     type: type,
//     icon: "nc-icon nc-bell-55",
//     autoDismiss: 7,
//     };
//     notificationAlertRef.current.notificationAlert(options);
// };

// Arrivals at Lisbon PT airport
const ARRIVALS_URL = `http://localhost:8080/api/arrivals`;

class FlightsTable extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            arrivalsData:[]
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
                    <th className="border-0">ID</th>
                    <th className="border-0">From</th>
                    <th className="border-0">Time first seen</th>
                    <th className="border-0">Time last seen</th>
                    <th className="border-0">Notify</th>
                </tr>
                </thead>
                <tbody>
                {//!!(arrivalsData)? "":
                    this.state.arrivalsData.map(
                        flight =>
                        <tr>
                            <td>{flight.icao24}</td>
                            <td>{flight.estDepartureAirport}</td>
                            <td>{flight.firstSeen}</td>
                            <td>{flight.lastSeen}</td>
                            <Button block /*onClick={() => notify("tl")}*/ variant="info">
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
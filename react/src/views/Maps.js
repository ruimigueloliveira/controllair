import React, { Component } from 'react';
import { Map, GoogleApiWrapper, InfoWindow, Marker } from 'google-maps-react';
import axios from 'axios';

const mapStyles = {
  width: '100%',
  height: '100%'
};

// Arrivals at Lisbon PT airport
const ARRIVALS_URL = `http://localhost:8080/api/arrivals`;

export class Maps extends Component {

  // TODO: check https://github.com/fullstackreact/google-maps-react/blob/master/src/GoogleApiComponent.js

    //event handlers for when the Map and the Marker are clicked
    //The onMarkerClick method is used to show the InfoWindow, which is a component
    //in the google-maps-react library which gives you the ability for a pop-up
    //window showing details of the clicked Marker
    onMarkerClick = (props, marker, e) =>
        this.setState({
          selectedPlace: props,
          activeMarker: marker,
          showingInfoWindow: true
        });

    //The onClose method is for closing the InfoWindow once a user clicks on
    //the close button on the InfoWindow.
    onClose = props => {
        if (this.state.showingInfoWindow) {
          this.setState({
            showingInfoWindow: false,
            activeMarker: null
          });
        }
    };

    constructor(props){
        super(props)
        this.state = {
            arrivalsData:[],
            showingInfoWindow: false,  // Hides or shows the InfoWindow
            activeMarker: {},          // Shows the active marker upon click
            selectedPlace: {}          // Shows the InfoWindow to the selected place upon a marker
        }

    }

    componentDidMount(){

          axios.get(ARRIVALS_URL)
          .then((response) => {
              this.setState({ arrivalsData: response.data});
          });
    }

    render() {


        return (
          <Map
            google={this.props.google}
            zoom={14}
            style={mapStyles}
            initialCenter={
              {
                lat: 38.775275699356314,
                lng: -9.135843353807045
              }
            }
          >
            
            {
              this.state.arrivalsData.map(
                flight =>
                        <tr>
                          <Marker
                            onClick={this.onMarkerClick}
                            position={{
                              lat: getRandomArbitrary(38.76450596898016, 38.78761708928799),
                              lng: getRandomArbitrary(-9.144989107270954, -9.12991438259596)
                            }}
                            name={"Voo id: "+ flight.icao24 + ", Plane Chassis: " + flight.callsign + ", Departure Airport: " + flight.estDepartureAirport + ", Last Seen: " + flight.lastSeen}
                          />
                          <InfoWindow
                            marker={this.state.activeMarker}
                            visible={this.state.showingInfoWindow}
                            onClose={this.onClose}
                          >
                            <div>
                              <h4>
                                {this.state.selectedPlace.name}
                              </h4>
                            </div>
                          </InfoWindow>
                        </tr>
                )
            }
            
          </Map>

        );
      }
}

function getRandomArbitrary(min, max) {
  return Math.random() * (max - min) + min;
}

export default GoogleApiWrapper({
  apiKey: 'AIzaSyBk0ZnJTY4g4euP07og1_w5_5FSRcJ-y4k'
})(Maps);
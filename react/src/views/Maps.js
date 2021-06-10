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

    state = {
        showingInfoWindow: false,
        activeMarker: {},
        selectedPlace: {},
    };

    onMarkerClick = (props, marker, e) =>
        this.setState({
          selectedPlace: props,
          activeMarker: marker,
          showingInfoWindow: true
        });

    //The onClose method is for closing the InfoWindow once a user clicks on
    //the close button on the InfoWindow.
    onMapClicked = (props) => {
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

    renderPlanes(){
        var count = 0;
        console.log("3253465y")
        console.log(this.state.arrivalsData)
        return this.state.arrivalsData.map(flight => {
            count += 1;
            return <Marker
                onClick = { this.onMarkerClick }
                title = { "Airplane: " + count }
                position={{
                  lat: getRandomArbitrary(38.76450596898016, 38.78761708928799),
                  lng: getRandomArbitrary(-9.144989107270954, -9.12991438259596)
                }}
                name={"Voo id: "+ flight.icao24 + ", Plane Chassis: " + flight.callsign + ", Departure Airport: " + flight.estDepartureAirport + ", Last Seen: " + flight.lastSeen}
                icon={{
                      url: 'https://pics.clipartpng.com/Airplane_PNG_Clipart-421.png',
                      scaledSize: new google.maps.Size(30, 30)
                }}
            />
        })
    }

    render(){

        return(
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
                onClick={this.onMapClicked}
            >
                <div>{ this.renderPlanes() } </div>
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
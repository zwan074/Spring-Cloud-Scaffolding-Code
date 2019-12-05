const React = require('react');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = { 
          responseData : ""
        };

        this.GET = this.GET.bind(this);
        this.sendRequest = this.sendRequest.bind(this);
    }

    GET(e) {
        e.preventDefault();
        const data = new FormData(e.target);
        this.setState ( {responseData : ''});
        console.log(data.get('URL'),data.get('PAYLOAD'))
        fetch('' + data.get('URL') , {
            method: 'GET',
        })
        .then(res => res.json() )
        .then ( 
            data => {
                this.setState ( {responseData : JSON.stringify(data)});
                console.log(data);
            }
        );
    
    }

    POST(e) {
        e.preventDefault();
        const data = new FormData(e.target);
        this.setState ( {responseData : ''});
        console.log(data.get('URL'),data.get('PAYLOAD'))
        fetch('' + data.get('URL') , {
            method: 'POST',
        })
        .then(res => res.json() )
        .then ( 
            data => {
                this.setState ( {responseData : JSON.stringify(data)});
                console.log(data);
            }
        );
    
    }

    sendRequest(e){
        e.preventDefault();
        const data = new FormData(e.target);
        this.setState ( {responseData : ''});
        console.log(data.get('METHOD'));
        if (data.get('METHOD') == 1 ) {
            this.GET(e)
        }

    }

    render(){

        return(
            <div>
            <form onSubmit = {this.sendRequest} class="needs-validation" >
           
                <div class="form-row">
                    <div class="col-md-3 mb-3">
                        <label for="validationCustom04">METHOD</label>
                        <select class="custom-select" name = "METHOD" required>
                            <option selected>Choose...</option>
                            <option value="1">GET</option>
                            <option value="2">POST</option>
                            <option value="3">PUT</option>
                            <option value="4">DELETE</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="validationCustom05">URL</label>
                        <input type="text" class="form-control" name="URL" required/>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="validationCustom05">PAYLOAD</label>
                        <input type="text" class="form-control" name="PAYLOAD" />
                    </div>
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            
            
            </form>
            <div class="border border-primary">
                RESPONSE: <br></br>
                {this.state.responseData}
            </div>
            
            </div>
        )
    }

}

export default App;
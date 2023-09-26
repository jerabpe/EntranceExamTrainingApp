import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import Form from 'react-bootstrap/Form';

class TreeNodeProblem extends React.Component {

    state = {
        fullText: "",
        q1: "Kolik je v rotě vojínů?",
        q2: "Kolik osob v rotě vydalo rozkaz k nástupu?",
        q3: "Kolik osob v rotě dostalo rozkaz k nástupu?",
        q1Result: -1,
        q2Result: -1,
        q3Result: -1,
    }
    

    loadNew = () => {
        fetch("http://localhost:8080/tree/problem")
            .then(response => response.json())
            .then(data => {
                console.log(data);
                this.setState(data);
            })
            .catch(console.log);
    }

    componentDidMount() {
        this.loadNew();
    }

    checkResults = (e) => {
        e.preventDefault();
        e.stopPropagation();
        const r1 = e.currentTarget[0];
        const r2 = e.currentTarget[1];
        const r3 = e.currentTarget[2];
        console.log([r1.value, this.state.q1Result]);
        /*if(r1.value != this.state.q1Result){
            r1.style.border = "2px solid red";
        } else {
            r1.style.border = "2px solid green";
        }

        if(r2.value != this.state.q2Result){
            r2.style.border = "2px solid red";
        } else {
            r2.style.border = "2px solid green";
        }

        if(r3.value != this.state.q3Result){
            r3.style.border = "2px solid red";
        } else {
            r3.style.border = "2px solid green";
        }*/

    }

    render() {
        return(
            <>
            <h1 className="mx-3">Tree node problem</h1>
            <div id="treeNodeProblem" className="fs-6 m-3">
                {this.state.fullText}
            </div>
            <Form className="m-3" onSubmit={this.checkResults}>
                <Form.Label htmlFor="q1">{this.state.q1}</Form.Label>
                <InputGroup className="mb-3">
                <Form.Control
                    placeholder="Odpověď"
                    aria-describedby="q1"
                />
                </InputGroup>
                <Form.Label htmlFor="q2">{this.state.q2}</Form.Label>
                <InputGroup className="mb-3">
                <Form.Control
                    placeholder="Odpověď"
                    aria-describedby="q2"
                />
                </InputGroup>
                <Form.Label htmlFor="q3">{this.state.q3}</Form.Label>
                <InputGroup className="mb-3">
                <Form.Control
                    placeholder="Odpověď"
                    aria-describedby="q3"
                />
                </InputGroup>
                <Button id="checktreeResult" variant="success" type="submit">Check</Button>
                <Button id="generateTreeProblemButton" onClick={this.loadNew} className="mx-3" variant="warning">Generate</Button>
            </Form>
            
            </>
        );
    }
}

export default TreeNodeProblem;


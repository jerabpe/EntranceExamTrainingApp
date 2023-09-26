import React from 'react'

export default function FractionProblem() {
  return (
    <>
    <h1>Fraction problem</h1>
    <button id="generateButton">Generate</button>
    <br/>
    <div id="problem" class="problem">
    </div>
    <div>
        <input id="resultInput" type="text"/>
        <button id="checkResult">Check</button>
    </div>
    <div>
        <p id="result"></p>
    </div>
    </>
  );
}

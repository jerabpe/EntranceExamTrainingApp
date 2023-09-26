import React from 'react'

export default function CalculusProblem() {
  return (
    <>
    <h1>Calculus Problem</h1>
    <div>
        <button id="generateCalculusButton">Generate</button>
        <br/>
        <div id="calculusProblem" class="problem">
        </div>
        <div>
            <input id="calcResultInput" type="number"/>
            <button id="checkCalcResult">Check</button>
        </div>
        <div>
            <p id="calcResult"></p>
        </div>
    </div>
    </>
  )
}

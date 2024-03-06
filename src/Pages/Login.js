import React, { useState } from "react";
import axios from "axios";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent default form submission behavior

    try {
      const response = await axios.post("http://localhost:8080/validate", {
        email: email,
        password: password,
      });

      console.log(response.data);

      if (response.data === "adminhome") {
        window.location.href = "/adminhome";
      } else if (response.data === "customerhome") {
        window.location.href = "/customerhome";
      } else {
        alert("Login Failed");
      }
    } catch (error) {
      console.error("Error during login:", error);
      alert("An error occurred during login");
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h2>USER LOGIN:</h2>
        <label>Email:</label>
        <br />
        <input
          type="email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <br />
        <br />
        <label>Password:</label>
        <br />
        <input
          type="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <br />
        <br />
        <button type="submit">LOGIN</button>
      </form>
    </div>
  );
}

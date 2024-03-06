import React from "react";
import { Link } from "react-router-dom";

export default function Index() {
  return (
    <section>
      <Link to="/login">LOGIN</Link>
      <br />
      <br />
      <Link to="/registration">REGISTER</Link>
    </section>
  );
}

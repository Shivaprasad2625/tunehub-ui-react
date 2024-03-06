import React from "react";
import { Link } from "react-router-dom";

export default function CustomerHome() {
  return (
    <div>
      Welcome to Customer Home <br />
      <Link to="/exploresongs">Explore Songs</Link>
    </div>
  );
}

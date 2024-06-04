import React from "react";
import { Collapse } from "antd";
import "./faq.css";

const items = [
  {
    key: "1",
    label: <p className="title">Where do I sign up?</p>,
    children: (
      <p className="description">
        You can sign up for CodeRED Astra in the near future.
      </p>
    ),
  },
  {
    key: "2",
    label: <p className="title">Do I need a team?</p>,
    children: (
      <p className="description">
        Yes! You will need a team. You may have up to four people within a team.
      </p>
    ),
  },
  {
    key: "3",
    label: <p className="title">What tracks will be available?</p>,
    children: <p className="description">More info coming soon !</p>,
  },
];

const FAQ = () => {
  const onChange = (key) => {
    console.log(key);
  };

  return <Collapse accordion items={items} onChange={onChange} />;
};

function AppFAQ() {
  return (
    <div className="blockFAQ">
      <h2 className="FAQTITLE">FAQ</h2>
      <div className="container">
        <FAQ />
      </div>
    </div>
  );
}

export default AppFAQ;

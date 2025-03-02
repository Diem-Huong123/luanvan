import { useState } from "react";
import "./css/SecondPart.css";

export default function SecondPart() {
  const [activeTab, setActiveTab] = useState("education");

  const tabs = {
    education: {
      heading: "Best Education",
      text: "Grad School is free educational HTML template with Bootstrap CSS layout. Feel free to use it for educational or commercial purposes. Aenean nec metus porttitor, fermentum est accumsan, ultrices augue. Integer dapibus porttitor du",
      image: "./image-01.png",
    },
    management: {
      heading: "Top Management",
      text: "You can modify this HTML layout by editing contents and adding more pages as you needed. Since this template has options to add dropdown menus, you can put many HTML pages.",
      image: "./image-02.png",
    },
    meeting: {
      heading: "Quality Meeting",
      text: "You can use this template to convert into a specific theme for any kind of CMS platform such as WordPress. For more information, you can contact us now. Sapien tellus vel ipsum. Pellentesque in ipsum ut orci vehicula sagittis et in libero. Etiam a neque.",
      image: "./image-03.png",
    },
  };

  return (
    <section className="part-two">
      <div className="container-part-two">
        <div className="why-us">
          <p>Why Choose CTU School</p>
        </div>
        <div className="part-two-nav">
          {Object.keys(tabs).map((key) => (
            <button
              key={key}
              className={activeTab === key ? "active" : ""}
              onClick={() => setActiveTab(key)}
            >
              {tabs[key].heading}
            </button>
          ))}
        </div>

        <div className="part-two-content">
          <img className="part-two-content-image" src={tabs[activeTab].image} alt="" />

          <div className="part-two-content-sub-content">
            <h1>{tabs[activeTab].heading}</h1>
            <p>{tabs[activeTab].text}</p>
          </div>
        </div>
      </div>
    </section>
  );
}

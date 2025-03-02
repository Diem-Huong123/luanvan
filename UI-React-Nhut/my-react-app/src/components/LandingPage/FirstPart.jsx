import "./css/FirstPartCss.css";

export default function FirstPart() {
  return (
    <div className="firstPart">
      <video autoPlay loop muted playsInline className="video-bg">
        <source src="/videoFirstPart.mp4" type="video/mp4" />
        Your browser does not support the video tag.
      </video>

      <div className="firstPart-content">
        <h3>GRADUATE SCHOOL OF MANAGEMENT</h3>
        <h1>
          <span className="highlight">YOUR</span> CLASSROOM
        </h1>
        <button className="discover-btn">DISCOVER MORE</button>
      </div>

      <div className="hiden-part">
        <div className="hiden-content-box">
          <div className="hiden-content">
            <h4>📖 Register for courses</h4>
            <p>Sinh viên có thể đăng ký học phần theo kế hoạch học tập</p>
          </div>
        </div>

        <div className="hiden-content-box">
          <div className="hiden-content">
            <h4>📅 Adjust your study plan</h4>
            <p>
              Sinh viên có thể tùy chỉnh kế hoạch học tập trước khi thời gian
              đăng ký học phần đến
            </p>
          </div>
        </div>

        <div className="hiden-content-box">
          <div className="hiden-content">
            <h4>🎓 Smooth registration</h4>
            <p>
              Nhờ tính năng chính xử lý đăng ký học phần được update cực tốt nên
              đăng ký sẽ rất mượt, nhanh chóng
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

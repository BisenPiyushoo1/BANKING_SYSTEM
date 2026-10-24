import { useState } from "react";
import "../styles/Login.css";
import { Link } from "react-router-dom";
import axios from "axios";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    setError("");
    setLoading(true);

    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/login",
        {
          email: email,
          password: password,
        }
      );

      console.log("Login successful");
      console.log("JWT Token:", response.data);

    } catch (err) {
      console.error("Login error:", err);

      if (err.response) {
        setError(
          typeof err.response.data === "string"
            ? err.response.data
            : "Login failed"
        );
      } else {
        setError("Unable to connect to server");
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-page">

      {/* Left side */}
      <section className="login-hero">
        <div className="brand">
          <div className="brand-logo">T</div>
          <span>TrustPay</span>
        </div>

        <div className="hero-content">
          <p className="eyebrow">SMARTER BANKING</p>

          <h1>
            Your money.
            <br />
            <span>Your control.</span>
          </h1>

          <p className="hero-text">
            A simple and secure way to manage your accounts,
            transfer money and keep track of your transactions.
          </p>
        </div>

        <div className="security-box">
          <div className="security-icon">✓</div>

          <div>
            <strong>Secure Banking</strong>
            <p>Your account is protected with secure authentication.</p>
          </div>
        </div>
      </section>

      {/* Right side */}
      <section className="login-section">
        <div className="login-card">

          <div className="mobile-brand">
            <div className="brand-logo">T</div>
            <span>TrustPay</span>
          </div>

          <h2>Welcome back</h2>

          <p className="subtitle">
            Sign in to access your banking dashboard.
          </p>

          <form onSubmit={handleSubmit}>

            <div className="form-group">
              <label htmlFor="email">Email address</label>

              <input
                id="email"
                type="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>

            <div className="form-group">

              <div className="password-row">
                <label htmlFor="password">Password</label>

                <button type="button">
                  Forgot password?
                </button>
              </div>

              <input
                id="password"
                type="password"
                placeholder="Enter your password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <label className="remember">
              <input type="checkbox" />
              <span>Remember me</span>
            </label>

            <button
              type="submit"
              className="login-button"
              disabled={loading}
            >
              {loading ? "Signing in..." : "Sign in"}
            </button>
            {error && (
              <p className="form-error">
                {error}
              </p>
            )}

          </form>

          <div className="divider">
            <span>OR</span>
          </div>

          <p className="register-text">
            Don't have an account?
           <Link to="/register" className="register-link">
             Create account
           </Link>
          </p>

        </div>
      </section>

    </div>
  );
}

export default Login;
const jwt = require("jsonwebtoken");

exports.authenticate = (roles = []) => {
  return (req, res, next) => {
    const token = req.headers["authorization"]?.split(" ")[1];
    if (!token) return res.status(401).json({ message: "No token provided" });

    jwt.verify(token, "SECRET_KEY", (err, decoded) => {
      if (err) return res.status(403).json({ message: "Invalid or expired token" });

      // Role check
      if (roles.length > 0 && !roles.includes(decoded.role)) {
        return res.status(403).json({ message: "Forbidden: Role not allowed" });
      }

      req.user = decoded; // {id, email, role}
      next();
    });
  };
};

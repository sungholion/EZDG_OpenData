import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import TravelPage from './pages/TravelPage';
import './index.css';

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <div className="app-background min-h-screen">
        <Router>
          <Routes>
            <Route path="/example1" element={<TravelPage />} />
          </Routes>
        </Router>
      </div>
    </QueryClientProvider>
  );
}

export default App;
